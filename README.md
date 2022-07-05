burp i love beans

### FILENAME CONVENTION(not important)
```
<name of store> month date year.txt
```

## HEADER ARGS (separated by a space)
```
<store> <date> <card> <total>
```
* header must be the first line
* arguments separated by a space (be careful about trailing whitespace
```     
<store>         one string
<date>          mmddyy
<card>          last four digits of card used
<total price>   e.g. "420.69", no dollar sign
```

## BEAN FORMAT
```
<item> <price> <token> <token> ...
```
* each line following the header is one "bean"
* separated by spaces (be careful about trailing whitespace)

```
<item>          name of item as ONE word, e.g. oat_mill
<price>         e.g. 4.20, no dollar sign
                -> accepts subtraction e.g 4.20-0.69
                -> if you wanna add a negative value do 0-4.20
```

### Bean Tokens:
* always come after first two args
* can be in any order
* separated by spaces

**1) Gnome Token**
* single letter denoting owner of bean
* if there's no gnome token, bean is automatically split between all gnomes
* can denote more than one gnome in any order without spaces e.g. ca, ac

**2) Multiplier Token**
* e.g. x2, adds the item twice
