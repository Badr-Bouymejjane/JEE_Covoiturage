<!-- ======================================================================= -->
<!-- FICHIER: inscription.jsp (Formulaire d'inscription)                     -->
<!-- ======================================================================= -->
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription - Covoiturage Facile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <!-- Barre de navigation (identique à l'index) -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Covoit'App</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="connexion.jsp">Déjà un compte ? Connectez-vous</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Formulaire -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-body p-5">
                        <h2 class="card-title text-center mb-4">Créer un compte</h2>
                        <!-- Le formulaire envoie les données à la servlet "/inscription" -->
                        <form action="inscription" method="post">
                            <div class="mb-3">
                                <label for="nom" class="form-label">Nom</label>
                                <input type="text" class="form-control" id="nom" name="nom" required>
                            </div>
                            <div class="mb-3">
                                <label for="prenom" class="form-label">Prénom</label>
                                <input type="text" class="form-control" id="prenom" name="prenom" required>
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Adresse Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="mb-3">
                                <label for="motDePasse" class="form-label">Mot de passe</label>
                                <input type="password" class="form-control" id="motDePasse" name="motDePasse" required>
                            </div>
                             <div class="mb-3">
                                <label for="role" class="form-label">Je suis un...</label>
                                <select class="form-select" id="role" name="role" required>
                                    <option value="Passager" selected>Passager</option>
                                    <option value="Conducteur">Conducteur</option>
                                </select>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary btn-lg">S'inscrire</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>