import 'package:supabase_flutter/supabase_flutter.dart';
import '../core/supabase_client.dart';

class ActionsRepository {
  final SupabaseClient _sb = SupabaseManager.client;

  Future<void> saveConfirmPatioDelivery({
    required String cardId,
    required Map<String, String> photoUrls,
    required Map<String, Map<String, String>> expenses, // nome -> {valor, comprovanteUrl}
  }) async {
    await _sb.from('actions_confirm_patio_delivery').insert({
      'card_id': cardId,
      'photos': photoUrls,
      'expenses': expenses,
      'created_at': DateTime.now().toIso8601String(),
    });
  }

  Future<void> saveCarTowed({
    required String cardId,
    required String photoUrl,
    required Map<String, Map<String, String>> expenses,
  }) async {
    await _sb.from('actions_car_towed').insert({
      'card_id': cardId,
      'photo_url': photoUrl,
      'expenses': expenses,
      'created_at': DateTime.now().toIso8601String(),
    });
  }

  Future<void> saveMechanicalTow({
    required String cardId,
    required String reason,
  }) async {
    await _sb.from('actions_mechanical_tow').insert({
      'card_id': cardId,
      'reason': reason,
      'created_at': DateTime.now().toIso8601String(),
    });
  }

  Future<void> saveAssignChofer({
    required String cardId,
    required String choferName,
    required String choferEmail,
    required String date,
    required String time,
  }) async {
    await _sb.from('actions_assign_chofer').insert({
      'card_id': cardId,
      'chofer_name': choferName,
      'chofer_email': choferEmail,
      'collection_date': date,
      'collection_time': time,
      'created_at': DateTime.now().toIso8601String(),
    });
  }
}


