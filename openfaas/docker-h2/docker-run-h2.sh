docker run --rm -d --name h2 \
  --network networth-net \
  -p 8082:8082 -p 1521:1521 \
  h2:1
