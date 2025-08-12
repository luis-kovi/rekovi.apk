/create view public.v_pipefy_cards_detalhada as
select
  id,
  card_id,
  phase_id,
  phase_name,
  created_at,
  finished_at,
  created_by,
  public_url,
  sync_timestamp,
  updated_at,
  sync_type,
  fields,
  all_fields_json,
  COALESCE(
    get_json_value (fields, 'Placa do Veículo'::text),
    get_json_value (fields, 'Placa do Veículo '::text)
  ) as placa_veiculo,
  COALESCE(
    get_json_value (fields, 'Modelo do Veículo'::text),
    get_json_value (fields, 'Modelo do Veículo '::text)
  ) as modelo_veiculo,
  COALESCE(
    get_json_value (fields, 'Nome do driver'::text),
    get_json_value (fields, 'Nome do driver '::text)
  ) as nome_driver,
  COALESCE(
    get_json_value (fields, 'Telefone de contato'::text),
    get_json_value (fields, 'Telefone de contato '::text)
  ) as telefone_contato,
  COALESCE(
    get_json_value (fields, 'Telefone opcional (se houver)'::text),
    get_json_value (fields, 'Telefone opcional (se houver) '::text)
  ) as telefone_opcional,
  COALESCE(
    get_json_value (fields, 'E-mail do cliente'::text),
    get_json_value (fields, 'E-mail do cliente '::text)
  ) as email_cliente,
  COALESCE(
    get_json_value (fields, 'Endereço de cadastro'::text),
    get_json_value (fields, 'Endereço de cadastro '::text)
  ) as endereco_cadastro,
  COALESCE(
    get_json_value (fields, 'Endereço onde o veículo está'::text),
    get_json_value (fields, 'Endereço onde o veículo está '::text)
  ) as endereco_recolha,
  COALESCE(
    get_json_value (fields, 'Link Mapa'::text),
    get_json_value (fields, 'Link Mapa '::text)
  ) as link_mapa,
  COALESCE(
    get_json_value (fields, 'Empresa responsável pela recolha'::text),
    get_json_value (fields, 'Empresa responsável pela recolha '::text)
  ) as empresa_recolha,
  COALESCE(
    get_json_value (fields, 'Origem da locação'::text),
    get_json_value (fields, 'Origem da locação '::text)
  ) as origem_locacao,
  COALESCE(
    get_json_value (fields, 'Valor da recolha'::text),
    get_json_value (all_fields_json::jsonb, 'Valor da recolha'::text)
  ) as valor_recolha,
  COALESCE(
    get_json_value (fields, 'Custo de km adicional'::text),
    get_json_value (
      all_fields_json::jsonb,
      'Custo de km adicional'::text
    )
  ) as custo_km_adicional,
  COALESCE(
    get_json_value (fields, 'E-mail do chofer'::text),
    get_json_value (fields, 'E-mail do chofer '::text)
  ) as email_chofer,
  initcap(
    COALESCE(
      NULLIF(
        get_json_value (fields, 'Nome do chofer que fará a recolha'::text),
        ''::text
      ),
      NULLIF(
        get_json_value (
          fields,
          'Nome do chofer que fará a recolha - Ativa'::text
        ),
        ''::text
      ),
      NULLIF(
        get_json_value (
          all_fields_json::jsonb,
          'Nome do chofer que fará a recolha'::text
        ),
        ''::text
      ),
      NULLIF(
        get_json_value (
          all_fields_json::jsonb,
          'Nome do chofer que fará a recolha - Ativa'::text
        ),
        ''::text
      )
    )
  ) as nome_chofer_recolha
from
  pipefy_cards
where
  phase_id::text <> all (
    array[
      '324450957'::character varying,
      '324450967'::character varying,
      '324451001'::character varying
    ]::text[]
  );