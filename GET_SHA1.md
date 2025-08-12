# 🔑 Como obter SHA-1 Fingerprint

## Método 1: Android Studio (Recomendado)

1. **Abra Android Studio**
2. **View** > **Tool Windows** > **Gradle**
3. **Expand**: `app` > `Tasks` > `android`
4. **Double-click**: `signingReport`
5. **No output**, procure por:
   ```
   Variant: debug
   Config: debug
   Store: C:\Users\[USER]\.android\debug.keystore
   Alias: androiddebugkey
   MD5: XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX
   SHA1: XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX
   SHA-256: [...]
   ```
6. **Copie a linha SHA1**

## Método 2: Terminal (alternativo)

No terminal do Android Studio (Terminal tab):
```bash
./gradlew signingReport
```

## Próximos passos:

1. **Copie o SHA-1**
2. **Vá para Google Cloud Console**
3. **Crie OAuth Client ID para Android**
4. **Cole o SHA-1** no campo fingerprint

---

**Exemplo de SHA-1:**
`A1:B2:C3:D4:E5:F6:07:18:29:3A:4B:5C:6D:7E:8F:90:A1:B2:C3:D4`
