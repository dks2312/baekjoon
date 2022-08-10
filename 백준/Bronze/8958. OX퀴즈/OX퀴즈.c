#include <stdio.h>
#include<stdlib.h>
int main(){
	int s[100]={0},i,j,n,o,x;
	char ox[100],z;
	
	scanf("%d%c",&n,&z);
	for(i=0;i<n;i++){
		gets(ox);
		o=x=0;
		for(j=0;ox[j]!='\0';j++){
			if(ox[j]=='O'){
				o++;
				s[i]+=o;
			}
			else if(ox[j]=='X')	o=0;
		}
	}
	
	for(i=0;i<n;i++){
		printf("%d\n",s[i]);
	}
}