# run vault in Dev mode
#@see https://hub.docker.com/_/vault?tab=description
## ! isnt working as expected at this time. Server does not appear to start nor does it show up as a running contianer
docker run --cap-add=IPC_LOCK -d --rm --name=vault vault -p 8200:8200