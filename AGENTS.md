## Agents

This document describes the team of agents implemented within the *accent* application. 
Each agent fills a role and has "a very particular set of skills". 
Currently, we have pre-assigned commodity models that are believed to work well enough to fill each of these roles. 
As we obtain more data, we will have more highly optimized role assigments using any of the commercial provider models, a custom-architecture local model, or even a real person. 

### Syndi (Synapse Agent)

Syndi is the principal (aka project manager) agent; she knows about common Synapse workflows (through underlying prompts and -- in process -- custom training). 
She can interact with Synapse directly for common functions, and for other things can work with a predefined set of agents (at the moment, Syndi cannot be connected to a new agent dynamically). 
"Connecting" Syndi to a new agent is a matter of adding the interface to another agent. 
While Syndi currently uses an OpenAI model, that may not be the case later on. 
It is expected that there *are* limits on the number of agents that Syndi can interface with in that performance will degrade as the number increases (which might reflect the same coordination overhead issues in human interactions). 

To provide good overall performance for the user, therefore, we desire:
- Syndi to be fine-tuned and highly intuitive to make the best decisions for common workflows. Examples are understanding the user's intent, deciding when and which other agent should be called, how to interpret errors sensibly, etc. This is the difference between having a smart but new employee doing their job with a bit of guidance (prompts) vs having a smart employee who's been doing the job for years. Currently, Syndi is *not* fine-tuned as we need to collect data on "successful" interactions with a user as well as what can possibly go wrong.
- Having specialist agents at Syndi's disposal that are optimized (e.g. in terms of accuracy and cost-effectiveness). Occasionally we may reimplement an agent or replace it with a better version provided by someone else.  

Syndi is the default agent the user interacts with in *accent*. 
Other agents can be easily consulted and tested independently of Syndi, but only within in the developer workflow.

### Extraction Agent

TBD
