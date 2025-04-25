FROM openjdk:17
WORKDIR /app

# Install git and necessary tools
RUN apt-get update && apt-get install -y git

# Copy the entrypoint script
COPY entrypoint.sh .

# Make the script executable
RUN chmod +x entrypoint.sh

# Set entrypoint
ENTRYPOINT ["./entrypoint.sh"]
