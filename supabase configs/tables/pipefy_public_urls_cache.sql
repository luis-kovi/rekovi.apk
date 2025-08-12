create table public.pipefy_public_urls_cache (
  id bigserial not null,
  cache_key character varying(255) not null,
  card_id character varying(255) not null,
  phase_id character varying(255) not null,
  public_url text not null,
  created_at timestamp with time zone null default now(),
  updated_at timestamp with time zone null default now(),
  constraint pipefy_public_urls_cache_pkey primary key (id),
  constraint pipefy_public_urls_cache_cache_key_key unique (cache_key)
) TABLESPACE pg_default;