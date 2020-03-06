#
# You must have a docker engine running, like DockerDesktop.
# Start it now before you do anything.
#

#Optional - Remove an old imaage if it exists. There is more likely a better way to do this.
#This will error out if the image does not exist. No big deal.
docker image rm  networth:1

#Build the image. **MUST** be in the same directory as the file named "Dockerfile"
#Builds an image and names it networth:1 and uploads
docker build -t networth:1 .

# @see https://docs.docker.com/engine/reference/commandline/run/
# run an instance  image created from the "docker build"
docker run --rm --name networth -p 8080:8080 -p 8082:8082 networth:1