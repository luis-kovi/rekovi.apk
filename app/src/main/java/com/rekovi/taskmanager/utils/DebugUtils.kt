package com.rekovi.taskmanager.utils

import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.SigningInfo
import android.os.Build
import android.util.Base64
import android.util.Log
import java.security.MessageDigest

object DebugUtils {
    
    fun logAppSigningInfo(context: Context) {
        try {
            val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.GET_SIGNING_CERTIFICATES
                )
            } else {
                @Suppress("DEPRECATION")
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.GET_SIGNATURES
                )
            }
            
            val signatures = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo.signingInfo?.let { signingInfo ->
                    if (signingInfo.hasMultipleSigners()) {
                        signingInfo.apkContentsSigners
                    } else {
                        signingInfo.signingCertificateHistory
                    }
                }
            } else {
                @Suppress("DEPRECATION")
                packageInfo.signatures
            }
            
            signatures?.forEach { signature ->
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val sha1Bytes = md.digest()
                
                // Converter bytes para hexadecimal com :
                val sha1Hex = sha1Bytes.joinToString(":") { 
                    String.format("%02X", it)
                }
                
                val mdSha256 = MessageDigest.getInstance("SHA-256")
                mdSha256.update(signature.toByteArray())
                val sha256 = Base64.encodeToString(mdSha256.digest(), Base64.NO_WRAP)
                
                Log.d("AppSignature", "=== INFORMAÇÕES DE ASSINATURA ===")
                Log.d("AppSignature", "Package: ${context.packageName}")
                Log.d("AppSignature", "SHA-1: $sha1Hex")
                Log.d("AppSignature", "SHA-256: $sha256")
                Log.d("AppSignature", "==================================")
                
                // Para facilitar cópia do Logcat
                Log.d("COPY_SHA1", sha1Hex)
            }
        } catch (e: Exception) {
            Log.e("AppSignature", "Erro ao obter assinatura", e)
        }
    }
    
    fun getKeyHash(context: Context): String? {
        return try {
            val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.GET_SIGNING_CERTIFICATES
                )
            } else {
                @Suppress("DEPRECATION")
                context.packageManager.getPackageInfo(
                    context.packageName,
                    PackageManager.GET_SIGNATURES
                )
            }
            
            val signature = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo.signingInfo?.apkContentsSigners?.get(0)
            } else {
                @Suppress("DEPRECATION")
                packageInfo.signatures?.get(0)
            }
            
            signature?.let {
                val md = MessageDigest.getInstance("SHA")
                md.update(it.toByteArray())
                Base64.encodeToString(md.digest(), Base64.NO_WRAP)
            }
        } catch (e: Exception) {
            null
        }
    }
}
