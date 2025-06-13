<!-- ======================================================================= -->
<!-- FICHIER: index.jsp (Page d'accueil)                                     -->
<!-- ======================================================================= -->
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil - Covoiturage Facile</title>
    <!-- Intégration de Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .hero-section {
            background: url('https://placehold.co/1200x500/007bff/ffffff?text=Covoiturez+Simplement') no-repeat center center;
            background-size: cover;
            color: white;
            padding: 100px 0;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Barre de navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Covoit'App</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="trajets.jsp">Voir les trajets</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="connexion.jsp">Connexion</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-primary" href="inscription.jsp">Inscription</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Section principale (Hero) -->
    <header class="hero-section">
        <div class="container">
            <h1 class="display-4">Voyagez ensemble, économisez plus</h1>
            <!-- <p class="lead">Trouvez le trajet parfait ou proposez vos places libres en quelques clics.</p> -->
            <a href="trajets.jsp" class="btn btn-lg btn-light">Trouver un trajet</a>
        </div>
    </header>

    <!-- Pied de page -->
    <footer class="bg-dark text-white text-center p-4 mt-5">
        <div class="container">
            <p>&copy; 2025 Covoit'App. Tous droits réservés.</p>
        </div>
    </footer>

    <!-- Intégration de Bootstrap JS (optionnel) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>