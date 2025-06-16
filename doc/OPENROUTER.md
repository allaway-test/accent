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

;; Create an agent using OpenRouter with Gemini 2.5 Pro Preview
(def agent (create-agent {:provider :openrouter
                          :model "google/gemini-2.5-pro-preview"
                          :role "You are a helpful assistant"
                          :tools []}))

;; Ask a question
(ask agent "What is machine learning?")

;; Switch to o3-pro via OpenRouter
(require '[accent.chat :refer [switch-model]])
(switch-model agent "openai/o3-pro")
(ask agent "Explain transformers in deep learning")

;; Switch to DeepSeek R1 via OpenRouter
(switch-model agent "deepseek/deepseek-r1-distill-qwen-7b")
(ask agent "What are the benefits of open source models?")
```

## Available Models

OpenRouter provides access to models from multiple providers. For a complete and up-to-date list of available models, see [OpenRouter's model documentation](https://openrouter.ai/docs#models).

Popular models include:

- **OpenAI**: `openai/o3-pro`, `openai/gpt-4.1-nano`
- **Google**: `google/gemini-2.5-pro-preview`, `google/gemini-2.5-flash-preview-05-20:thinking`, `google/gemini-2.0-flash-exp:free`, `google/gemma-3n-e4b-it:free`
- **DeepSeek**: `deepseek/deepseek-r1-distill-qwen-7b`, `deepseek/deepseek-r1-0528-qwen3-8b`

## Benefits of OpenRouter

1. **Single API**: Access multiple model providers with one API key
2. **Cost Comparison**: Compare costs across different models and providers
3. **Redundancy**: Switch providers if one has downtime
4. **Experimentation**: Easy to test different models for your use case