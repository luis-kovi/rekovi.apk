import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:url_launcher/url_launcher.dart';
import 'auth/signin_page.dart';
import 'mobile/mobile_home_page.dart';

class RekoviApp extends StatelessWidget {
  const RekoviApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Rekovi Mobile',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFFFF355A)),
        useMaterial3: true,
        scaffoldBackgroundColor: const Color(0xFFF7F9FA),
        inputDecorationTheme: InputDecorationTheme(
          border: const OutlineInputBorder(),
          hintStyle: TextStyle(color: Colors.grey.shade600),
          labelStyle: TextStyle(color: Colors.grey.shade700),
        ),
        fontFamily: 'Inter',
      ),
      routes: {
        '/': (_) => const SignInPage(),
        '/mobile': (_) => const MobileHomePage(),
      },
    );
  }
}

