import 'dart:io';
import 'package:mime/mime.dart';
import 'package:path/path.dart' as p;
import 'package:supabase_flutter/supabase_flutter.dart';
import '../core/app_config.dart';
import '../core/supabase_client.dart';

class StorageRepository {
  final SupabaseClient _sb = SupabaseManager.client;

  Future<String> uploadFile({required File file, required String pathPrefix}) async {
    final bucket = AppConfig.storageBucket;
    final ext = p.extension(file.path).replaceAll('.', '').toLowerCase();
    final mime = lookupMimeType(file.path) ?? 'application/octet-stream';
    final fileName = '${DateTime.now().millisecondsSinceEpoch}.${ext.isEmpty ? 'bin' : ext}';
    final storagePath = '$pathPrefix/$fileName';

    final data = await file.readAsBytes();
    final res = await _sb.storage.from(bucket).uploadBinary(storagePath, data, fileOptions: FileOptions(contentType: mime));
    return _sb.storage.from(bucket).getPublicUrl(res);
  }
}


