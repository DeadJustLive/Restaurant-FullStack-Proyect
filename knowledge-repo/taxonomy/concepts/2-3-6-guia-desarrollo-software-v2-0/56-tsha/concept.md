# T_SHA}

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 56)

## Contenido
# T_SHA}

- 	- name: kubernetes deploy
- 	run: |
- aws eks update-kubeconfig --name ${CLUSTER_NAME} --region us-east-2
- 	kubectl 	set 	image 	deploy/$APP_NAME
$APP_NAME=${AWS_ACCOUNT_ID}.dkr.ecr.us-east-2.amazonaws.com/${REPOSITORY}:${SHORT_SHA
} -n ${NAMESPACE} --record
División de Gobierno Digital | Lineamientos para desarrollo de software 	33

-- 33 of 33 --
