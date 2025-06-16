# OpenRouter Usage Example

This document demonstrates how to use accent with OpenRouter to access multiple model providers through a single API.

## Configuration

### Environment Variable
```bash
export OPENROUTER_API_KEY="sk-or-your-api-key-here"
```

### Config File
```clojure
{:tools false
 :db-env :prod
 :init-model-provider "OpenRouter"
 :openrouter-api-key "sk-or-your-api-key-here"}
```

## Example Usage

```clojure
(require '[accent.chat :refer [create-agent ask]])

;; Create an agent using OpenRouter with GPT-4o Mini
(def agent (create-agent {:provider :openrouter
                          :model "openai/gpt-4o-mini"
                          :role "You are a helpful assistant"
                          :tools []}))

;; Ask a question
(ask agent "What is machine learning?")

;; Switch to Claude via OpenRouter
(require '[accent.chat :refer [switch-model]])
(switch-model agent "anthropic/claude-3-5-sonnet-20241022")
(ask agent "Explain transformers in deep learning")

;; Switch to Llama via OpenRouter
(switch-model agent "meta-llama/llama-3.1-8b-instruct")
(ask agent "What are the benefits of open source models?")
```

## Available Models

OpenRouter provides access to models from multiple providers. For a complete and up-to-date list of available models, see [OpenRouter's model documentation](https://openrouter.ai/docs#models).

Popular models include:

- **OpenAI**: `openai/gpt-4o`, `openai/gpt-4o-mini`
- **Anthropic**: `anthropic/claude-3-5-sonnet-20241022`, `anthropic/claude-3-haiku-20240307`
- **Google**: `google/gemini-pro`
- **Meta**: `meta-llama/llama-3.1-8b-instruct`

## Benefits of OpenRouter

1. **Single API**: Access multiple model providers with one API key
2. **Cost Comparison**: Compare costs across different models and providers
3. **Redundancy**: Switch providers if one has downtime
4. **Experimentation**: Easy to test different models for your use case