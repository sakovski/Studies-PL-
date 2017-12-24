INC=/usr/include/postgresql
LIB=/usr/lib
CFLAGS=-I$(INC)
LDLIBS=-L$(LIB) -lpq
CC=gcc

ALL=Finalmain
# ponizej przyklady regul i zaleznosci kompilacji wybranych plikow
main: Finalmain.c
	$(CC) $(CFLAGS) -o Finalmain Finalmain.c $(LDLIBS)

clean:
	@rm -f *.o *~ $(ALL)
all: Finalmain
