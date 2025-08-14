import 'package:flutter/material.dart';

class MobileFilterPanel extends StatefulWidget {
  final List<String> phases;
  final ValueChanged<Set<String>> onChanged;

  const MobileFilterPanel({super.key, required this.phases, required this.onChanged});

  @override
  State<MobileFilterPanel> createState() => _MobileFilterPanelState();
}

class _MobileFilterPanelState extends State<MobileFilterPanel> {
  final Set<String> _selected = {};

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text('Filtros', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
            const SizedBox(height: 12),
            ...widget.phases.map((p) => CheckboxListTile(
                  contentPadding: EdgeInsets.zero,
                  dense: true,
                  value: _selected.contains(p),
                  onChanged: (v) {
                    setState(() {
                      if (v == true) {
                        _selected.add(p);
                      } else {
                        _selected.remove(p);
                      }
                    });
                  },
                  title: Text(p),
                )),
            const SizedBox(height: 8),
            Row(
              children: [
                Expanded(
                  child: OutlinedButton(
                    onPressed: () {
                      setState(() => _selected.clear());
                    },
                    child: const Text('Limpar'),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: FilledButton(
                    onPressed: () => widget.onChanged(_selected),
                    child: const Text('Aplicar'),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 8),
          ],
        ),
      ),
    );
  }
}


