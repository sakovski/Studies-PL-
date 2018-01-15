class Progress
  attr_accessor :id, :account, :workout

  def initialize(id, account, workout)
    @id = id
    @account = account
    @workout = workout
  end

  def to_s
    "#{account.login} - #{workout}"
  end
end
