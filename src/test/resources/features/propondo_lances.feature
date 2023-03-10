# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
	Dado um lance valido
	Quando propoe o lance ao leilao
	Entao o lance eh aceito
	
Cenario: Propondo varios lances validos
	Dado um lance de 1.0 real do usuario "fulano"
	E um lance de 100.0 real do usuario "beltrano"
	Quando propoe varios lances ao leilao
	Entao os lances sao aceitos
	
Esquema do Cenario: um lance invalido
	Dado um lance invalido de <valor> real e do '<usuario>'
	Quando propoe o lance ao leilao
	Entao o lance nao eh aceito

Exemplos:
    | valor | Beltrano |
    |    0  | Fulano   |
    |    -1 | Ciclano  |

Cenario: Propondo uma sequencia de lances
	Dado dois lances
	    | valor    | nome    |
    	|    1.0   | fulano  |
    	|    100.0 | fulano  |
	Quando propoe varios lances ao leilao
	Entao o segundo lance nao eh aceito
	    
