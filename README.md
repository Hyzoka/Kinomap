# Résumé

Test technique Android réalisé par Duvin Sébastien en 7-8h.

## Stack technique

### Kotlin
Langage de programmation officiel pour le développement d'application Android native. Le plus utilisé, la communauté est grandissante.

### MVVM
Pattern structurant le mieux adapté pour l'implémentation de la logique d'une vue. Facile à tester et bonne synergie avec Compose et Koin.

Son implémentation est assez naturelle et pas verbeux.

### Compose
Permet l'implémentation des écrans. Écriture du code très naturelle permettant la mise à jour automatique de l'écran en fonction des données branchées à elle.

Utiliser Compose plutôt que du XML rend la verbosité des écrans moins lourdes et permet de s'affranchir d'un nouveau langage qu'est le XML par le Kotlin. Il nous permet d'être plus proche des activités / fragments puisque son implémentation peut être dans la même classe ou dans le même package.

### Koin
Solution d'injection de dépendance qui est beaucoup moins verbeux que Dagger/Hilt qui est adapté aux projets Kotlin. La gestion des dépendances est beaucoup plus agréable sur Koin plutôt que sur d'autres solutions d'injection de dépendance.

### Mockito
Solution de mock pour les tests unitaires permettant de nous concentrer sur la logique qu'on souhaite tester en nous fournissant des données mockées. Son implémentation est assez simple, il couvre un large panel de fonctionnalités sur les mocks en test unitaire.

### Navigation component
Bibliothèque de navigation fournissant des classes et fonctions nous permettant de naviguer entre plusieurs écrans. Il est très intéressant à utiliser dans des projets même de petite taille car sa gestion de la backstack la rend indispensable pour une bonne gestion de la superposition des écrans.

La bibliothèque de navigation est très adapté à Compose et permet une écriture très naturelle des écrans qui la compose ainsi que des liens qu'il y a entre eux.

## Architecture

L'utilisation de Repository et de DataSource nous permet de bien diviser le rôle de chaque entité dans l'acquisition de données et ainsi de pouvoir intervenir sur chacune de ses étapes. Chaque entité a son rôle bien défini ce qui nous permet d'optimiser nos tests d'une part mais aussi de pouvoir rendre flexible l'implémentation de nouvelles fonctionnalités.

Les ViewModels sont quelque choses de très puissant puisqu'il nous permet de porter toute la logique de l'écran dans une seule classe et possède son propre scope. Koin s'adapte très bien aux ViewModel puisqu'il fournit des bibliothèque technique adapté à cette architecture.

Ils perdurent tout au long du cycle de vie de l'écran et permet une sauvegarde des données de l'écran.
