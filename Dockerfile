FROM openjdk:17-jdk-slim
WORKDIR /app

# Install git and necessary tools
RUN apt-get update && apt-get install -y \
    git \
    curl \
    jq \
    nano \
    && apt-get clean

# Copy the entrypoint script
COPY entrypoint.sh .

# Make the script executable
RUN chmod +x entrypoint.sh

# Set entrypoint
ENTRYPOINT ["./entrypoint.sh"]
