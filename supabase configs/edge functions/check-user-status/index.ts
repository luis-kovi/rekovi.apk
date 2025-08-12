import { createClient } from 'https://esm.sh/@supabase/supabase-js@2';
import { corsHeaders } from '../_shared/cors.ts';
Deno.serve(async (req)=>{
  // Lida com a requisição CORS preflight
  if (req.method === 'OPTIONS') {
    return new Response('ok', {
      headers: corsHeaders
    });
  }
  try {
    const supabaseAdmin = createClient(Deno.env.get('SUPABASE_URL') ?? '', Deno.env.get('SUPABASE_SERVICE_ROLE_KEY') ?? '');
    // Obtém o usuário a partir do token de autorização
    const authHeader = req.headers.get('Authorization');
    if (!authHeader) {
      throw new Error('Acesso não autorizado. Token não fornecido.');
    }
    const jwt = authHeader.replace('Bearer ', '');
    const { data: { user } } = await supabaseAdmin.auth.getUser(jwt);
    if (!user) {
      throw new Error('Acesso não autorizado. Token inválido ou expirado.');
    }
    // Verifica o e-mail do usuário na tabela de pré-aprovados
    const { data, error } = await supabaseAdmin.from('pre_approved_users').select('status').eq('email', user.email).single() // Usa .single() pois o e-mail deve ser único
    ;
    // Retorna "not_found" se o usuário não estiver na tabela
    if (error && error.code === 'PGRST116') {
      return new Response(JSON.stringify({
        status: 'not_found'
      }), {
        headers: {
          ...corsHeaders,
          'Content-Type': 'application/json'
        }
      });
    }
    if (error) {
      throw error;
    }
    // Retorna o status encontrado no banco de dados
    return new Response(JSON.stringify({
      status: data.status
    }), {
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json'
      }
    });
  } catch (error) {
    return new Response(JSON.stringify({
      error: error.message
    }), {
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json'
      },
      status: 500
    });
  }
});
