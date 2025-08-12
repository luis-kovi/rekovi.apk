// supabase/functions/get-cards/index.ts
import { createClient } from 'https://esm.sh/@supabase/supabase-js@2';
import { corsHeaders } from '../_shared/cors.ts';
const KANBAN_PHASES = [
  'Fila de Recolha',
  'Aprovar Custo de Recolha',
  'Tentativa 1 de Recolha',
  'Tentativa 2 de Recolha',
  'Tentativa 3 de Recolha',
  'Nova tentativa de recolha',
  'Desbloquear Veículo',
  'Solicitar Guincho',
  'Confirmação de Entrega no Pátio'
];
Deno.serve(async (req)=>{
  if (req.method === 'OPTIONS') {
    return new Response('ok', {
      headers: corsHeaders
    });
  }
  try {
    const supabaseAdmin = createClient(Deno.env.get('SUPABASE_URL'), Deno.env.get('SUPABASE_SERVICE_ROLE_KEY'));
    const authHeader = req.headers.get('Authorization');
    if (!authHeader) throw new Error("Acesso não autorizado. Token não fornecido.");
    const jwt = authHeader.replace('Bearer ', '');
    const { data: { user } } = await supabaseAdmin.auth.getUser(jwt);
    if (!user) throw new Error("Acesso não autorizado. Token inválido ou expirado.");
    const permissionType = user.app_metadata.permissionType?.toLowerCase() || 'default';
    let query = supabaseAdmin.from('v_pipefy_cards_detalhada').select('*').in('phase_name', KANBAN_PHASES);
    // ================== CORREÇÃO APLICADA AQUI ==================
    if (permissionType === 'ativa' || permissionType === 'onsystem') {
      query = query.ilike('empresa_recolha', permissionType);
    } else if (permissionType === 'chofer') {
      query = query.eq('email_chofer', user.email);
    // A condição agora verifica se a permissão NÃO é kovi E NÃO é admin
    } else if (permissionType !== 'kovi' && permissionType !== 'admin') {
      query = query.eq('id', 'impossivel');
    }
    // Se a permissão for 'kovi' ou 'admin', nenhum filtro extra é aplicado.
    // =============================================================
    const { data, error } = await query;
    if (error) throw error;
    const transformedCards = data.map((card)=>({
        id: card.card_id,
        placa: card.placa_veiculo,
        nomeDriver: card.nome_driver,
        chofer: card.nome_chofer_recolha,
        emailChofer: card.email_chofer,
        empresaResponsavel: card.empresa_recolha,
        dataCriacao: card.created_at,
        faseAtual: card.phase_name,
        urlPublica: card.public_url,
        enderecoRecolhaUrl: card.link_mapa,
        valorRecolha: card.valor_recolha,
        custoKmAdicional: card.custo_km_adicional,
        modeloVeiculo: card.modelo_veiculo,
        telefoneContato: card.telefone_contato,
        telefoneOpcional: card.telefone_opcional,
        enderecoCadastro: card.endereco_cadastro,
        enderecoVeiculo: card.endereco_recolha,
        origemLocacao: card.origem_locacao
      }));
    const responseData = {
      cards: transformedCards,
      permissionType: permissionType,
      lastUpdate: new Date().toISOString()
    };
    return new Response(JSON.stringify(responseData), {
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json'
      }
    });
  } catch (err) {
    return new Response(JSON.stringify({
      error: err.message
    }), {
      status: 500,
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json'
      }
    });
  }
});
