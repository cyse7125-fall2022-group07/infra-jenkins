# Ansible Playbooks for AWS Infrastructure & Jenkins Setup
## Pre-requirements
```shell
- Configure AWS cli (aws account set-up with proper profile credentials/region needed).
- Install Ansible
```
## Allocate Elastic IP
```shell
- Manually Allocate an Eastic IP address to Jenkins instance and tag it appropriately using AWS console.
```
## Setup networking components such as VPC, subnets, route table, internet gateway, security groups and launch EC2 instance using following command:
```shell
ansible-playbook playbooks/jenkins_infra/setup.yml -e "aws_profile=profile ec2_image=image-id aws_region=region domain=domainname sub_domain=subdomainname group_name=groupname email=useremailaddress ec2_keypair=keyname ec2_instance_type=instancetype"
```
## Teardown Network components and EC2 instance using following command:
```shell
ansible-playbook playbooks/jenkins_infra/teardown.yml -e "aws_profile=profile ec2_image=image-id aws_region=region domain=domainname sub_domain=subdomainname group_name=groupname email=useremailaddress ec2_keypair=keyname ec2_instance_type=instancetype"
```
## Manage Jenkins Plugins, nginx, certbot and to use installed Certbot to generate certificates using following command
```shell
ansible-playbook playbooks/jenkins.yml -e "sub_domain=subdomainname email=useremailaddress user=admin user_password=password"
```