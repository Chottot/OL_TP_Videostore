# OL_TP_Videostore

Clément HOTTOT AL3-1

<p>
Bloaters <br>
 Long Method -> Customer.Statement()<br>
 Primitive Obsession -> movie.priceCode<br>
  Divergent Change
</p>
 
 Code Smells| Long Method | Primitive Obsession | Divergent Change|
--- | --- | --- | ---
technique | Extract Method | Replace Data Value with Object | Extract Superclass|

## resumer

commence vraiment à partir du commit ad8a0bce avant c'etait pour pouvoir lancer/compiler le code<br>
jusqu'au commit a40bd08f renommage des variables, agencement du code et correction des warnings<br>
jusqu'au commit a4a1f687 correction des code Smells "Long Method" et "Primitive Obsession"<br>
jusqu'au commit 94fc4288 ajout de fonctionnalité de sauvegarde <br>
commit a065dd43 correction du code Smell "Divergent Change" (aurait dû être fait avant en même temps que les autres corrections de code Smell)<br>
jusqu'au dernier commit ajout de feature <br>

## Point a améliorer

Il a plien de Warning "unused" ce qui est en soit un code Smell mais qui sont tous sur des Getters/Setters
j'ai developpé l'application plus dans le sens d'un module qui serait plus tard utilisé par une interface utilisateur 
vu qu'il n'y a pas d'interface graphique ces Setteres et Getters ne sont pas utilisés.

L'uitlisation de l'implementation Serializable pour sauvegarder en Localpeut posser problème de rétrocompatibiliter de la base de donnée déja enregisté si l'on modifie les class même si l'on ne modifie pas les donnée des class
la sauvegarde dans Json par exemple pourrait être une alternative 

l'ajout d'un class pour sauvegarder les donnée dans un base de donnée non local (exemple SQL)
