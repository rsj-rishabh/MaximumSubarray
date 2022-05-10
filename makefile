JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

jar: $(classes)
	jar -cvmf manifest.txt MarsBase.jar $(classes)

clean :
	rm -f *.class