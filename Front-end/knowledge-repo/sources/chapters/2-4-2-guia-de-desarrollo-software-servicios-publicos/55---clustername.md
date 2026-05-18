# - 	CLUSTER_NAME:

- on:
- 	workflow_dispatch:
- 	push:
- 	branches:
- 	- "main"
- 	- "develop"
- 	tags:
- 	- 'prod-*'
- 	- 'develop-*'
-
- jobs:
- 	deploy:
- 	runs-on: RUNNER_NAME
- 	steps:
- 	- uses: actions/checkout@v2
-
- 	- name: set env
- 	run: echo "TAG=${GITHUB_REF#refs/*/}" >> $GITHUB_ENV
-
- 	- name: commit-sha para tag de imagen
- 	run: echo "SHORT_SHA=`echo ${GITHUB_SHA} | cut -c 1-8`" >> $GITHUB_ENV
-
- 	- name: build
- 	run: |
- docker 	build 	-t
${AWS_ACCOUNT_ID}.dkr.ecr.us-east-2.amazonaws.com/${REPOSITORY}:latest
-t
${AWS_ACCOUNT_ID}.dkr.ecr.us-east-2.amazonaws.com/${REPOSITORY}:${SHOR
T_SHA} .
- 	- name: upload image
- 	run: |
- aws ecr get-login-password --region us-east-2 | docker login
--username 	AWS_USERNAME 	--password-stdin
${AWS_ACCOUNT_ID}.dkr.ecr.us-east-2.amazonaws.com
- docker 	push
${AWS_ACCOUNT_ID}.dkr.ecr.us-east-2.amazonaws.com/${REPOSITORY}:latest
- docker 	push
${AWS_ACCOUNT_ID}.dkr.ecr.us-east-2.amazonaws.com/${REPOSITORY}:${SHOR