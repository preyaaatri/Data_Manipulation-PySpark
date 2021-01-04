# Pick your favorite docker-stacks image
FROM jupyter/all-spark-notebook

USER root

WORKDIR /app

USER $NB_UID

# copy project to container
COPY ./app/ /home/jovyan/work
