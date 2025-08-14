import 'package:flutter/material.dart';

class MobileHomePage extends StatelessWidget {
  const MobileHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Rekovi - Mobile')),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          const Text('Home mobile (placeholder)'),
          const SizedBox(height: 12),
          FilledButton(
            onPressed: () {},
            child: const Text('Abrir tarefa (em breve)'),
          )
        ],
      ),
    );
  }
}

