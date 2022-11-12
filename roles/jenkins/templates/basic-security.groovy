#!groovy

import jenkins.model.*
import hudson.security.*
import hudson.util.*
import jenkins.install.*
def instance = Jenkins.getInstance()
instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("{{ user }}", "{{ user_password }}")
instance.setSecurityRealm(hudsonRealm)
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.save()