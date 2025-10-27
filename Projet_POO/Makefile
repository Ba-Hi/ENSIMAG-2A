# Example de makefile pour compiler le squelette de code distribué
# Vous pouvez compléter ce makefile, mais étant donnée la taille du projet, 
# il est FORTEMENT recommandé d'utiliser un IDE!

# Organisation:
#  1) Les sources (*.java) se trouvent dans le répertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) sont générés dans le répertoire bin
#     La hiérarchie des sources (par package) est conservée.
#
#  3) Une librairie gui.jar est distribuée pour l'interface grapique. 
#     Elle se trouve dans le sous-répertoire lib.
#
# Compilation:
#  Options de javac:
#   -d : répertoire dans lequel sont générés les .class compilés
#   -sourcepath : répertoire dans lequel sont cherchés les .java
#   -classpath : répertoire dans lequel sont cherchées les classes compilées (.class et .jar)

GUI_JAR = lib/gui.jar
SRC_DIR = src
BIN_DIR = bin
MAIN_CLASS = TestBallsSimulator

CLASSPATH = $(BIN_DIR):$(GUI_JAR)

SOURCES = $(wildcard $(SRC_DIR)/*.java)

.PHONY: all compile run clean

all: run

compile: $(BIN_DIR)
	javac -d $(BIN_DIR) -cp $(CLASSPATH) $(SOURCES)

run: compile
	java -cp $(CLASSPATH) $(MAIN_CLASS)

$(BIN_DIR):
	mkdir -p $(BIN_DIR)

clean:
	rm -rf $(BIN_DIR)

