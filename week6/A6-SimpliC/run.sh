java -jar compiler.jar $1 > x.s && as --gstabs x.s -o x.o && ld x.o && ./a.out
