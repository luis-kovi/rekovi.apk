import 'package:flutter/material.dart';
import '../core/supabase_client.dart';
import '../data/cards_repository.dart';
import '../data/models/card_model.dart';
import '../data/user_repository.dart';
import '../data/models/user_data.dart';
import 'widgets/mobile_header.dart';
import 'widgets/mobile_task_card.dart';
import 'widgets/mobile_filter_panel.dart';

class MobileHomePage extends StatefulWidget {
  const MobileHomePage({super.key});

  @override
  State<MobileHomePage> createState() => _MobileHomePageState();
}

class _MobileHomePageState extends State<MobileHomePage> {
  final CardsRepository _repo = CardsRepository();
  bool _loading = true;
  String? _error;
  List<CardModel> _cards = const [];
  Set<String> _selectedPhases = {};
  UserData? _userData;

  @override
  void initState() {
    super.initState();
    _init();
  }

  Future<void> _init() async {
    try {
      await SupabaseManager.init();
      final user = SupabaseManager.client.auth.currentUser;
      if (user == null) {
        if (!mounted) return;
        Navigator.of(context).pushReplacementNamed('/');
        return;
      }
      // Buscar dados do usuário para aplicar regras de permissão
      final userRepo = UserRepository();
      final ud = await userRepo.getUserData(user.email ?? '');
      if (ud == null || ud.status != 'active') {
        if (!mounted) return;
        setState(() => _error = 'Usuário sem acesso.');
        return;
      }
      _userData = ud;
      final cards = await _repo.fetchCards(permissionType: ud.permissionType, userEmail: ud.email);
      if (!mounted) return;
      setState(() => _cards = cards);
    } catch (e) {
      setState(() => _error = 'Erro ao carregar cards');
    } finally {
      if (mounted) setState(() => _loading = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MobileHeader(
        userEmail: SupabaseManager.client.auth.currentUser?.email,
        isUpdating: _loading,
        onLogout: () async {
          await SupabaseManager.client.auth.signOut();
          if (!mounted) return;
          Navigator.of(context).pushReplacementNamed('/');
        },
        onOpenFilter: () {
          showModalBottomSheet(
            context: context,
            showDragHandle: true,
            isScrollControlled: true,
            builder: (_) => MobileFilterPanel(
              phases: CardsRepository.validPhases,
              onChanged: (set) {
                setState(() => _selectedPhases = set);
                Navigator.pop(context);
              },
            ),
          );
        },
      ),
      body: _loading
          ? const Center(child: CircularProgressIndicator())
          : _error != null
              ? Center(child: Text(_error!))
              : RefreshIndicator(
                  onRefresh: _init,
                  child: ListView.separated(
                    padding: const EdgeInsets.all(12),
                    itemBuilder: (_, i) {
                      final visible = _cards.where((c) => _selectedPhases.isEmpty || _selectedPhases.contains(c.faseAtual)).toList();
                      if (i >= visible.length) return const SizedBox.shrink();
                      final c = visible[i];
                      return MobileTaskCard(
                        card: c,
                        onTap: () {
                          showModalBottomSheet(
                            context: context,
                            isScrollControlled: true,
                            useSafeArea: true,
                            builder: (_) => MobileTaskModal(
                              card: c,
                              userAreas: _userData?.areaAtuacao,
                            ),
                          );
                        },
                      );
                    },
                    separatorBuilder: (_, __) => const Divider(height: 1),
                    itemCount: _cards.where((c) => _selectedPhases.isEmpty || _selectedPhases.contains(c.faseAtual)).length,
                  ),
                ),
    );
  }
}

