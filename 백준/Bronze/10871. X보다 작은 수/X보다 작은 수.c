#include<stdio.h>

main(){
	int i,a,n,x;
	
	scanf("%d%d",&a,&x);
	
	for(i=0;i<a;i++){
		scanf("%d",&n);
		if(n<x) printf("%d ",n);
	}
}