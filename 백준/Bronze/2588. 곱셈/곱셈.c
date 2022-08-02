#include<stdio.h>
main(){
	int a,b,c,d;
	
	scanf("%d%1d%1d%1d",&a,&b,&c,&d);
    printf("%d\n",d*a);
    printf("%d\n",c*a);
    printf("%d\n",b*a);
    printf("%d\n",(b*100+c*10+d)*a);
}