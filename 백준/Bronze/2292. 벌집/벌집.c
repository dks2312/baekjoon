#include<stdio.h>

main() {
	int n,i=1;
	
	scanf("%d",&n);
	
	for(i=1;n-1>0;i++){
		n-=6*i;
	}
	
	printf("%d",i);
	
}
