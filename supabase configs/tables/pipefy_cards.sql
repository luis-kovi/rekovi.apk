create table public.pipefy_cards (
  id bigserial not null,
  card_id character varying(255) not null,
  phase_id character varying(255) not null,
  phase_name character varying(255) not null,
  created_at timestamp with time zone null,
  finished_at timestamp with time zone null,
  created_by character varying(255) null,
  public_url text null,
  fields jsonb null default '{}'::jsonb,
  all_fields_json text null,
  sync_timestamp timestamp with time zone null default now(),
  updated_at timestamp with time zone null default now(),
  sync_type character varying(50) null,
  constraint pipefy_cards_pkey primary key (id),
  constraint pipefy_cards_card_id_key unique (card_id)
) TABLESPACE pg_default;