# Makefile são TAB-SENSITIVE!
# Tome muito CUIDADO em não confundir espaços com tabs
# Isso aqui são   4 espaços:    |
# Isso aqui é     1     tab:	|

# Linhas que começam com um - (híphen) são linhas que podem falhar
# sem fazer a build inteira falhar.
# veja: https://stackoverflow.com/questions/2670130/make-how-to-continue-after-a-command-fails


docs:
	doxygen
	-pip install sphinx-rtd-theme groundwork-sphinx-theme
	-pip3 install sphinx-rtd-theme groundwork-sphinx-theme
	sphinx-build -aE . ./build_docs/sphinx/

clean:
	mvn clean
	-rm -rfv ./build_docs/sphinx/* ./build_docs/sphinx/\.*
	-rm -rfv ./build_docs/doxygen/* ./build_docs/doxygen/\.*
	touch ./build_docs/doxygen/garantir_diretorio_pro_git.txt
	touch ./build_docs/sphinx/garantir_diretorio_pro_git.txt

test:
	mvn test

.PHONY: test clean docs
