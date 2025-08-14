import 'package:flutter/material.dart';

class MobileHeader extends StatelessWidget implements PreferredSizeWidget {
  final String? userEmail;
  final bool isUpdating;
  final VoidCallback? onOpenFilter;

  const MobileHeader({super.key, this.userEmail, this.isUpdating = false, this.onOpenFilter});

  @override
  Size get preferredSize => const Size.fromHeight(56);

  @override
  Widget build(BuildContext context) {
    return AppBar(
      titleSpacing: 8,
      title: Row(
        children: [
          Image.network(
            'https://i.ibb.co/d4kbJGGY/rekovi-identity-updated-1-removebg-preview.png',
            height: 28,
          ),
          const SizedBox(width: 8),
          const Text('Rekovi'),
          const Spacer(),
          if (isUpdating) const SizedBox(width: 16, height: 16, child: CircularProgressIndicator(strokeWidth: 2)),
          IconButton(
            tooltip: 'Filtros',
            onPressed: onOpenFilter,
            icon: const Icon(Icons.filter_alt_outlined),
          ),
        ],
      ),
    );
  }
}


