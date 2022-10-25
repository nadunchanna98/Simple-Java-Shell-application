
all: run

run: compile 
	java Shell 

compile: Shell.java
	javac Shell.java

clean: 
	rm -f *~
	rm -f *.class 
