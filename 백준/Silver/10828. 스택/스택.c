#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(){
	int n,stek_size=-1;
	int stek[10000];
	char str[10];
	
	scanf("%d",&n);
	
	for( ; n>0; n--){
		scanf("%s", str);
		
		if(!strcmp(str,"push")){
			scanf("%d", &stek[++stek_size]);
		}
		else if(!strcmp(str,"pop")){
			if(stek_size==-1) printf("-1\n");
			else printf("%d\n",stek[stek_size--]);
		}
		else if(!strcmp(str,"size")){
			printf("%d\n",stek_size+1);
		}
		else if(!strcmp(str,"empty")){
			if(stek_size==-1) printf("1\n");
			else printf("0\n");
		}
		else if(!strcmp(str,"top")){
			if(stek_size==-1) printf("-1\n");
			else printf("%d\n",stek[stek_size]);
		}
	}
}