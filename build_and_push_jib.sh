#!/bin/bash

# Define Docker Hub username
DOCKER_HUB_USERNAME="ankushgoyal11"

# List of microservices and their directories (alternating values)
MICROSERVICES=(
    "accounts" "./accounts"
    "cards" "./cards"
    "loans" "./loans"
    "eurekaserver" "./eurekaserver"
    "gatewayserver" "./gatewayserver"
    "configserver" "./configserver"
)

# Define image tag
IMAGE_TAG="s12"

# Ensure Docker is running
if ! docker info >/dev/null 2>&1; then
    echo "Docker is not running. Please start Docker and try again."
    exit 1
fi

# Login to Docker Hub
echo "Logging into Docker Hub..."
docker login || { echo "Docker login failed"; exit 1; }

# Loop through microservices (processing name and directory in pairs)
for ((i = 0; i < ${#MICROSERVICES[@]}; i += 2)); do
    SERVICE="${MICROSERVICES[i]}"
    DIR="${MICROSERVICES[i + 1]}"
    FULL_IMAGE_NAME="$DOCKER_HUB_USERNAME/$SERVICE:$IMAGE_TAG"

    echo "Building Docker image for $SERVICE using Jib..."

    # Check if the directory exists before proceeding
    if [[ ! -d "$DIR" ]]; then
        echo "Directory $DIR not found! Skipping..."
        continue
    fi

    # Navigate to the microservice directory
    cd "$DIR" || exit 1

    # Build Docker image using Jib
    mvn compile jib:dockerBuild || { echo "Failed to build $FULL_IMAGE_NAME"; exit 1; }

    # Tag the image properly
    docker tag "$SERVICE" "$FULL_IMAGE_NAME"

    echo "Pushing image: $FULL_IMAGE_NAME..."

    # Push the image to Docker Hub
    docker push "$FULL_IMAGE_NAME" || { echo "Failed to push $FULL_IMAGE_NAME"; exit 1; }

    echo "Successfully pushed: $FULL_IMAGE_NAME"

    # Return to the original directory
    cd - >/dev/null
done

echo "All images built and pushed successfully!"
