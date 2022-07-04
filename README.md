burp i love beans
#FILENAME CONVENTION(not important)
<name of store> month date year.txt

#HEADER ARGS (separated by a space)
        - header must be the first line
        - arguments separated by a space (be careful about trailing whitespace
        - <store> <date> <card> <total>
<store> one string
<date> mmddyy
<last four digits of the card used>
<total price> decimal format ->  0.00

#BEAN FORMAT:
        - each line following the header is one "bean"
        - separated by spaces (be careful about trailing whitespace)

<item name> one string
<price> double - 0.00
        -> accepts subtraction e.g 4.20-0.69
        -> if you wanna add a negative value use 0-4.20

##Bean Tokens:
        - ALWAYS come after first two args
        - can be in any order
        - separated by spaces

###1) Gnome Token
        -is a single letter denoting owner of bean
        -if there's no gnome token, bean is automatically split between all gnomes
        - can be in any order e.g. ca, ac
