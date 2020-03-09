#
# You must have a docker engine running, like DockerDesktop.
# Start it now before you do anything.
#

# package any changes to code
mvn package;

#Optional - Remove an old imaage if it exists. There is more likely a better way to do this.
#This will error out if the image does not exist. No big deal.
docker image rm  networth:1

#Build the image. **MUST** be in the same directory as the file named "Dockerfile"
#Builds an image and names it networth:1 and uploads
docker build -t networth:1 .

# mae sure the networth-network is running on the Decker engine
./openfaas/network/create-network.sh

#start the db
./openfaas/docker-h2/docker-run-h2.sh

# Run and bind REST ports to localhost:8080
docker run --rm -d --name networth \
  -p 8080:8080 \
  --network networth-net \
  networth:1
