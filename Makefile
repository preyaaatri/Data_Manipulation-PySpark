# Copyright (c) Jupyter Development Team.
# Distributed under the terms of the Modified BSD License.

.PHONY: help check image notebook

IMAGE:=my-notebook

PORT?=8888
APP_NAME?=data_manipulation-pyspark
WORK_VOLUME?=/app
SPARK_IMAGE?=$(APP_NAME):latest


stop: ## Stop and remove a running container
	docker stop $(APP_NAME) || true && docker rm $(APP_NAME) || true

build: ## Build the container
	docker build -t $(APP_NAME) .

image: DOCKER_ARGS?=
image:
	@docker build --rm $(DOCKER_ARGS) -t $(IMAGE) .

run: stop build
	docker run -p $(PORT):8888 \
		--name $(APP_NAME) \
		-e NB_USER=jovyan -e CHOWN_HOME=yes -e CHOWN_EXTRA_OPTS='-R' --user root -w /home/jovyan/work/ \
		$(SPARK_IMAGE) \
