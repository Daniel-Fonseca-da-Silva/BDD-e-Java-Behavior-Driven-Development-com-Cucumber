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
