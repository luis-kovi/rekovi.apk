// supabase/functions/get-users/index.ts
import { createClient } from 'https://esm.sh/@supabase/supabase-js@2';
import { corsHeaders } from '../_shared/cors.ts';
Deno.serve(async (req)=>{
  if (req.method === 'OPTIONS') {
    return new Response('ok', {
      headers: corsHeaders
    });
  }
  try {
    const supabaseAdmin = createClient(Deno.env.get('SUPABASE_URL') ?? '', Deno.env.get('SUPABASE_SERVICE_ROLE_KEY') ?? '');
    const { search = '', page = 1, limit = 10 } = await req.json();
    const offset = (page - 1) * limit;
    let query = supabaseAdmin.from('pre_approved_users').select('*', {
      count: 'exact'
    });
    if (search) {
      query = query.or(`email.ilike.%${search}%,empresa.ilike.%${search}%`);
    }
    const { data, error, count } = await query.order('email', {
      ascending: true
    }).range(offset, offset + limit - 1);
    if (error) throw error;
    return new Response(JSON.stringify({
      users: data,
      count
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
