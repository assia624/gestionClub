-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 09 jan. 2026 à 21:18
-- Version du serveur : 9.1.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_club`
--

-- --------------------------------------------------------

--
-- Structure de la table `clubs`
--

DROP TABLE IF EXISTS `clubs`;
CREATE TABLE IF NOT EXISTS `clubs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_creation` date DEFAULT NULL,
  `description` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre_membres` int DEFAULT NULL,
  `president` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkeb1tciraa2nj27ks8i6f3smh` (`nom`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `clubs`
--

INSERT INTO `clubs` (`id`, `categorie`, `date_creation`, `description`, `nom`, `nombre_membres`, `president`) VALUES
(3, 'Science', '2021-01-10', 'Club de robotique et innovation technologique', 'Club Robotique', 20, 'Youssef Mansouri'),
(4, 'Art', '2020-03-20', 'Club de musique et orchestration', 'Club Musique', 15, 'Fatima Zahra El Fassi'),
(5, 'Art', '2021-05-12', 'Club de photographie et médias visuels', 'Club Photo', 12, 'Mehdi Tazi'),
(6, 'Culture', '2020-11-05', 'Club d\'échecs et jeux de stratégie', 'Club Échecs', 10, 'Karim Zahiri'),
(7, 'Science', '2021-02-18', 'Club de développement et programmation', 'Club Informatique', 30, 'Imane Benali');

-- --------------------------------------------------------

--
-- Structure de la table `evenements`
--

DROP TABLE IF EXISTS `evenements`;
CREATE TABLE IF NOT EXISTS `evenements` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacite` int DEFAULT NULL,
  `date_debut` datetime(6) NOT NULL,
  `date_fin` datetime(6) DEFAULT NULL,
  `description` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lieu` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `titre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `club_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9c2jedvhkfcpivkklo0nm5hvp` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `evenements`
--

INSERT INTO `evenements` (`id`, `capacite`, `date_debut`, `date_fin`, `description`, `lieu`, `titre`, `club_id`) VALUES
(7, 150, '2026-02-22 08:00:00.000000', '2026-02-22 16:00:00.000000', 'Compétition nationale de robotique', 'Centre de conférences', 'Compétition de Robotique', 3),
(8, 25, '2026-01-28 14:00:00.000000', '2026-01-28 18:00:00.000000', 'Introduction à la programmation Arduino', 'Laboratoire informatique', 'Workshop Arduino', 3),
(9, 40, '2026-02-14 09:00:00.000000', '2026-02-15 09:00:00.000000', 'Hackathon 24h sur l\'Internet des Objets', 'Salle de projet', 'Hackathon IoT', 3),
(10, 300, '2026-03-09 20:00:00.000000', '2026-03-09 23:00:00.000000', 'Grand concert avec tous les membres du club', 'Auditorium principal', 'Concert de Fin d\'Année', 4),
(11, 50, '2026-01-20 19:00:00.000000', '2026-01-20 22:00:00.000000', 'Session musicale improvisée ouverte à tous', 'Salle de musique', 'Jam Session', 4),
(12, 200, '2026-02-01 10:00:00.000000', '2026-02-07 18:00:00.000000', 'Exposition des meilleures photos de l\'année', 'Hall principal', 'Exposition Photo', 5),
(13, 20, '2026-01-25 08:00:00.000000', '2026-01-25 17:00:00.000000', 'Sortie photographique dans la forêt', 'Forêt de Bouskoura', 'Sortie Photo Nature', 5),
(14, 60, '2026-02-08 09:00:00.000000', '2026-02-10 09:00:00.000000', 'Compétition de programmation 48h', 'Laboratoire info', 'Hackathon Code', 7),
(15, 100, '2026-01-30 14:00:00.000000', '2026-01-30 17:00:00.000000', 'Conférence sur l\'Intelligence Artificielle', 'Amphithéâtre A', 'Conférence IA', 7);

-- --------------------------------------------------------

--
-- Structure de la table `membres`
--

DROP TABLE IF EXISTS `membres`;
CREATE TABLE IF NOT EXISTS `membres` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_inscription` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `filiere` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `niveau` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `club_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKmfvy2wpkq55hiuhbuixhw0ye9` (`email`),
  KEY `FKrcgpacrd1yiqnkcpefb6jkvrj` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `membres`
--

INSERT INTO `membres` (`id`, `date_inscription`, `email`, `filiere`, `niveau`, `nom`, `prenom`, `telephone`, `club_id`) VALUES
(25, '2024-11-08', 'omar.hassani@ecole.ma', 'Génie Électrique', 'M1', 'Hassani', 'Omar', '0690123456', 3),
(26, '2024-12-08', 'hamza.lahlou@ecole.ma', 'Informatique', 'L2', 'Lahlou', 'Hamza', '0601234567', 3),
(27, '2024-10-20', 'ayoub.marouani@ecole.ma', 'Automatique', 'M2', 'Marouani', 'Ayoub', '0612345679', 3),
(28, '2024-11-01', 'yassine.kadiri@ecole.ma', 'Mécanique', 'L3', 'Kadiri', 'Yassine', '0623456780', 3),
(29, '2024-12-18', 'yasmine.elfassi@ecole.ma', 'Arts', 'L1', 'El Fassi', 'Yasmine', '0634567891', 4),
(30, '2024-12-25', 'salma.chraibi@ecole.ma', 'Musicologie', 'L2', 'Chraibi', 'Salma', '0645678902', 4),
(31, '2024-11-10', 'mehdi.berrada@ecole.ma', 'Arts', 'L3', 'Berrada', 'Mehdi', '0656789013', 4),
(32, '2024-11-15', 'sofia.amrani@ecole.ma', 'Communication', 'L2', 'Amrani', 'Sofia', '0667890124', 5),
(33, '2024-10-05', 'adam.mansouri@ecole.ma', 'Arts visuels', 'M1', 'Mansouri', 'Adam', '0678901235', 5),
(34, '2024-09-01', 'imane.benali@ecole.ma', 'Informatique', 'M1', 'Benali', 'Imane', '0689012346', 7),
(35, '2024-09-15', 'khalid.tounsi@ecole.ma', 'Génie Logiciel', 'L3', 'Tounsi', 'Khalid', '0690123457', 7),
(36, '2024-08-20', 'fatima.ziani@ecole.ma', 'Data Science', 'M2', 'Ziani', 'Fatima', '0601234568', 7);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKl8ivthvih63lgxwa4uqwmbqj9` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `password`, `role`, `username`) VALUES
(1, '$2a$12$48sIVLrKd.rN0c7azvjAJ.o2xMRXGQK3J/FMP5czGjNCl2P3TfRGi', 'ROLE_ADMIN', 'admin'),
(2, '$2a$10$8TvXjbvV7Bn5cHx8qLZRJOvZUKq5p3kU7g9kP4VtG2gP1MzJr3Wjm', 'ROLE_PRESIDENT', 'president'),
(3, '$2a$10$YMcVLPKgH8MzD0bZq2B6EuXN0FQqxM5rT7PvU2sLjK9WxA3bR4CdS', 'ROLE_MEMBER', 'membre');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `evenements`
--
ALTER TABLE `evenements`
  ADD CONSTRAINT `FK9c2jedvhkfcpivkklo0nm5hvp` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`id`);

--
-- Contraintes pour la table `membres`
--
ALTER TABLE `membres`
  ADD CONSTRAINT `FKrcgpacrd1yiqnkcpefb6jkvrj` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
