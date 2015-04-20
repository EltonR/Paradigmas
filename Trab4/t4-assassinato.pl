estava(pedro, sm, segunda).
estava(pedro, sm, terca).
estava(pedro, poa, quarta).
estava(pedro, sm, quinta).
estava(pedro, apartamento, sexta).
estava(caren, poa, segunda).
estava(caren, poa, terca).
estava(caren, poa, quarta).
estava(caren, sm, quinta).
estava(caren, apartamento, sexta).
estava(henrique, apartamento, segunda).
estava(henrique, poa, terca).
estava(henrique, apartamento, quarta).
estava(henrique, apartamento, quinta).
estava(henrique, apartamento, sexta).
estava(bia, apartamento, segunda).
estava(bia, poa, terca).
estava(bia, poa, quarta).
estava(bia, sm, quinta).
estava(bia, sm, sexta).
estava(adriano, apartamento, segunda).
estava(adriano, apartamento, terca).
estava(adriano, sm, quarta).
estava(adriano, apartamento, quinta).
estava(adriano, apartamento, sexta).
estava(alice, apartamento, segunda).
estava(alice, poa, terca).
estava(alice, poa, quarta).
estava(alice, apartamento, quinta).
estava(alice, apartamento, sexta).
estava(bernardo, sm, segunda).
estava(bernardo, sm, terca).
estava(bernardo, poa, quarta).
estava(bernardo, sm, quinta).
estava(bernardo, apartamento, sexta).
estava(maria, apartamento, segunda).
estava(maria, sm, terca).
estava(maria, sm, quarta).
estava(maria, sm, quinta).
estava(maria, apartamento, sexta).

pobre(bia).
pobre(pedro).
pobre(maria).
pobre(bernardo).

rico(caren).
rico(alice).
rico(henrique).
rico(adriano).

insano(adriano).
insano(maria).

relacionamento(anita, bernardo).
relacionamento(bernardo, anita).
relacionamento(bernardo, caren).
relacionamento(caren, bernardo).
relacionamento(anita, pedro).
relacionamento(pedro, anita).
relacionamento(pedro, alice).
relacionamento(alice, pedro).
relacionamento(alice, henrique).
relacionamento(henrique, alice).
relacionamento(maria, henrique).
relacionamento(henrique, maria).
relacionamento(adriano, maria).
relacionamento(maria, adriano).
relacionamento(adriano, caren).
relacionamento(caren, adriano).

assassino(X) :- motivo(X), acesso(X).
acesso(X) :- aux(X), contato(X, arma), contato(X, chave).
motivo(X) :- insano(X); pobre(X); ciume(X, anita).
ciume(X,Z) :- relacionamento(X,Y), relacionamento(Y,Z).
ciume(Z,X) :- relacionamento(X,Y), relacionamento(Y,Z).
aux(X) :- estava(X, apartamento, quinta); estava(X, apartamento, sexta).

contato(X, baseball) :- estava(X, poa, quinta); estava(X, sm, quarta).
contato(X, martelo) :- estava(X, apartamento, quarta); estava(X, apartamento, quinta).
contato(X, arma) :- contato(X, baseball); contato(X, martelo).
contato(X, chave) :- estava(X, sm, segunda); estava(X, poa, terca).






