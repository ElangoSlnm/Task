# create ubuntu container
sudo docker run -it -P --privileged --name spark-node ubuntu /bin/bash

# start existing container
sudo docker start spark-node

# execute docker container
sudo docker exec -it --privileged spark-node /bin/bash

#
